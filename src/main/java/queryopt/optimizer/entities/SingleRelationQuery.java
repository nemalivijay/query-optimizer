package queryopt.optimizer.entities;

import java.util.List;

import queryopt.entities.Atribute;
import queryopt.entities.Relation;

public class SingleRelationQuery {
	private Relation relation;

	private List<Atribute> projectionAtributes;
	private List<Clause> selectionCnfClauses;
	private List<Atribute> groupingAtributes;

	public Relation getRelation() {
		return relation;
	}

	public void setRelation(Relation relation) {
		this.relation = relation;
	}

	public List<Atribute> getProjectionAtributes() {
		return projectionAtributes;
	}

	public void setProjectionAtributes(List<Atribute> projectionAtributes) {
		this.projectionAtributes = projectionAtributes;
	}

	public List<Clause> getSelectionCnfClauses() {
		return selectionCnfClauses;
	}

	public void setSelectionCnfClauses(List<Clause> selectionCnfClauses) {
		this.selectionCnfClauses = selectionCnfClauses;
	}

	public List<Atribute> getGroupingAtributes() {
		return groupingAtributes;
	}

	public void setGroupingAtributes(List<Atribute> groupingAtributes) {
		this.groupingAtributes = groupingAtributes;
	}

}
