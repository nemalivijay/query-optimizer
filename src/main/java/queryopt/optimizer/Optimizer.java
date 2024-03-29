package queryopt.optimizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import queryopt.entities.Relation;
import queryopt.optimizer.join.IndexNestedLoopsJoin;
import queryopt.optimizer.join.Join;
import queryopt.optimizer.join.NestedLoopsJoin;
import queryopt.optimizer.path.AccessPath;
import queryopt.optimizer.path.FullTableScan;
import queryopt.optimizer.path.MultipleIndexAccessPath;
import queryopt.optimizer.path.SingleIndexAccessPath;
import queryopt.optimizer.query.JoinQuery;
import queryopt.optimizer.query.SPJQuery;
import queryopt.optimizer.query.SingleRelationQuery;

public class Optimizer {
	private SPJQuery query;
	private List<List<? extends Plan>> allLeftDeepPlanTrees;
	private List<AccessPath> allAccessPaths;
	private HashMap<Relation, SingleRelationQuery> srqueries;

	public Optimizer(SPJQuery query) throws Exception {
		this.query = query;
	}

	public Plan generateBestPlan() throws Exception {

		srqueries = Utils.getSingleRelationQueriesFromSPJQuery(query);
		allAccessPaths = genSingleRelationPlans(srqueries);

		allLeftDeepPlanTrees = new ArrayList<List<? extends Plan>>();
		allLeftDeepPlanTrees.add(allAccessPaths);

		for (int i = 1; i < allAccessPaths.size(); i++) {
			List<JoinQuery> joinqueries = Utils.getJoinQueriesFromSPJQuery(allLeftDeepPlanTrees.get(i - 1), query,
					allAccessPaths);
			allLeftDeepPlanTrees.add(genMultipleRelationPlans(joinqueries, srqueries));
		}

		Plan bestPlan = null;
		long cost = Long.MAX_VALUE;
		for (Plan allRelationPlan : allLeftDeepPlanTrees.get(allLeftDeepPlanTrees.size() - 1))
			if (allRelationPlan.getCost() < cost) {
				cost = allRelationPlan.getCost();
				bestPlan = allRelationPlan;
			}
		return bestPlan;
	}

	private static List<Join> genMultipleRelationPlans(List<JoinQuery> joinQueries,
			HashMap<Relation, SingleRelationQuery> srqueries) throws Exception {

		List<Join> nRelationPlans = new ArrayList<Join>();

		for (JoinQuery joinQuery : joinQueries) {
			Join join = null;
			long cost = Long.MAX_VALUE;

			// Construct NestedLoops With FTS
			NestedLoopsJoin nestedLoops = new NestedLoopsJoin(joinQuery);
			cost = nestedLoops.getCost();
			join = nestedLoops;

			// Construct JoinQuery With Index Scan and RIDs
			IndexNestedLoopsJoin indexNestedLoops = new IndexNestedLoopsJoin(joinQuery);

			if (cost < indexNestedLoops.getCost()) {
				cost = indexNestedLoops.getCost();
				join = indexNestedLoops;
			}

			nRelationPlans.add(join);
		}
		return nRelationPlans;
	}

	private static List<AccessPath> genSingleRelationPlans(
			HashMap<Relation, SingleRelationQuery> singleRelationQueries) throws Exception {

		List<AccessPath> singleRelationAccessPaths = new ArrayList<AccessPath>();

		for (SingleRelationQuery srquery : singleRelationQueries.values()) {
			AccessPath accessPath = null;
			long cost = Long.MAX_VALUE;

			// FTS plan
			FullTableScan fts = new FullTableScan(srquery);
			accessPath = fts;
			cost = fts.getCost();

			// INDEX plans: single and multiple
			if (srquery.getRelation().getIndexes().size() > 0) {
				SingleIndexAccessPath singleIndex = new SingleIndexAccessPath(srquery);
				if (singleIndex.getCost() < cost) {
					cost = singleIndex.getCost();
					accessPath = singleIndex;
				}
				MultipleIndexAccessPath multipleIndex = new MultipleIndexAccessPath(srquery);
				if (multipleIndex.getCost() < cost) {
					cost = multipleIndex.getCost();
					accessPath = multipleIndex;
				}
			}
			singleRelationAccessPaths.add(accessPath);
		}
		return singleRelationAccessPaths;
	}

}
