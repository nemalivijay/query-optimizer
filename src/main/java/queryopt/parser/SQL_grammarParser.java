// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g 2009-12-10 16:40:12
package queryopt.parser;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;

import org.antlr.runtime.tree.*;

public class SQL_grammarParser extends DebugParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "QUERY", "LITERAL", "SELECT", "NAME", "STAR", "COUNT", "SUM", "AVG", "MIN", "MAX", "FROM", "WHERE", "IN", "EQ", "LS", "GT", "LS_EQ", "GT_EQ", "WS", "DIFF", "';'", "','", "'('", "')'", "'AND'", "'\\''"
    };
    public static final int WHERE=15;
    public static final int T__29=29;
    public static final int STAR=8;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int LS=18;
    public static final int MAX=13;
    public static final int LITERAL=5;
    public static final int COUNT=9;
    public static final int MIN=12;
    public static final int SUM=10;
    public static final int EOF=-1;
    public static final int NAME=7;
    public static final int WS=22;
    public static final int IN=16;
    public static final int DIFF=23;
    public static final int AVG=11;
    public static final int GT=19;
    public static final int QUERY=4;
    public static final int EQ=17;
    public static final int FROM=14;
    public static final int LS_EQ=20;
    public static final int GT_EQ=21;
    public static final int SELECT=6;

    // delegates
    // delegators

    public static final String[] ruleNames = new String[] {
        "invalidRule", "where", "and", "clause", "select", "query1", "op", 
        "query", "from", "literal", "aggregate_funct"
    };
     
        public int ruleLevel = 0;
        public int getRuleLevel() { return ruleLevel; }
        public void incRuleLevel() { ruleLevel++; }
        public void decRuleLevel() { ruleLevel--; }
        public SQL_grammarParser(TokenStream input) {
            this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
        }
        public SQL_grammarParser(TokenStream input, int port, RecognizerSharedState state) {
            super(input, state);
            DebugEventSocketProxy proxy =
                new DebugEventSocketProxy(this,port,adaptor);
            setDebugListener(proxy);
            setTokenStream(new DebugTokenStream(input,proxy));
            try {
                proxy.handshake();
            }
            catch (IOException ioe) {
                reportError(ioe);
            }
            TreeAdaptor adap = new CommonTreeAdaptor();
            setTreeAdaptor(adap);
            proxy.setTreeAdaptor(adap);
        }
    public SQL_grammarParser(TokenStream input, DebugEventListener dbg) {
        super(input, dbg);

         
        TreeAdaptor adap = new CommonTreeAdaptor();
        setTreeAdaptor(adap);

    }
    protected boolean evalPredicate(boolean result, String predicate) {
        dbg.semanticPredicate(result, predicate);
        return result;
    }

    protected DebugTreeAdaptor adaptor;
    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = new DebugTreeAdaptor(dbg,adaptor);

    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }


    public String[] getTokenNames() { return SQL_grammarParser.tokenNames; }
    public String getGrammarFileName() { return "/home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g"; }


    List<RecognitionException> exceptions = new ArrayList<RecognitionException>();

    public  void reportError(RecognitionException e)
    {
        exceptions.add(e);
    }

    public boolean hasError()
    {
     return exceptions.size() > 0; 
    }

    public String getErrorMessage()
    {
    	if (exceptions.size() > 0)
    		return this.getErrorMessage(exceptions.get(0), this.getTokenNames());
    	else
    		return "No Errors";
    }

    public String getErrorPosition()
    {
    	return this.getErrorHeader(exceptions.get(0));
    }


    public static class query_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "query"
    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:44:1: query : query1 ';' EOF ;
    public final SQL_grammarParser.query_return query() throws RecognitionException {
        SQL_grammarParser.query_return retval = new SQL_grammarParser.query_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal2=null;
        Token EOF3=null;
        SQL_grammarParser.query1_return query11 = null;


        CommonTree char_literal2_tree=null;
        CommonTree EOF3_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "query");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(44, 1);

        try {
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:45:2: ( query1 ';' EOF )
            dbg.enterAlt(1);

            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:45:4: query1 ';' EOF
            {
            root_0 = (CommonTree)adaptor.nil();

            dbg.location(45,4);
            pushFollow(FOLLOW_query1_in_query59);
            query11=query1();

            state._fsp--;

            adaptor.addChild(root_0, query11.getTree());
            dbg.location(45,14);
            char_literal2=(Token)match(input,24,FOLLOW_24_in_query61); 
            dbg.location(45,19);
            EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_query64); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        dbg.location(45, 21);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "query");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "query"

    public static class query1_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "query1"
    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:47:1: query1 : select from ( where )? -> ^( QUERY from select ( where )? ) ;
    public final SQL_grammarParser.query1_return query1() throws RecognitionException {
        SQL_grammarParser.query1_return retval = new SQL_grammarParser.query1_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        SQL_grammarParser.select_return select4 = null;

        SQL_grammarParser.from_return from5 = null;

        SQL_grammarParser.where_return where6 = null;


        RewriteRuleSubtreeStream stream_select=new RewriteRuleSubtreeStream(adaptor,"rule select");
        RewriteRuleSubtreeStream stream_from=new RewriteRuleSubtreeStream(adaptor,"rule from");
        RewriteRuleSubtreeStream stream_where=new RewriteRuleSubtreeStream(adaptor,"rule where");
        try { dbg.enterRule(getGrammarFileName(), "query1");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(47, 1);

        try {
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:48:2: ( select from ( where )? -> ^( QUERY from select ( where )? ) )
            dbg.enterAlt(1);

            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:48:4: select from ( where )?
            {
            dbg.location(48,4);
            pushFollow(FOLLOW_select_in_query177);
            select4=select();

            state._fsp--;

            stream_select.add(select4.getTree());
            dbg.location(48,11);
            pushFollow(FOLLOW_from_in_query179);
            from5=from();

            state._fsp--;

            stream_from.add(from5.getTree());
            dbg.location(48,16);
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:48:16: ( where )?
            int alt1=2;
            try { dbg.enterSubRule(1);
            try { dbg.enterDecision(1);

            int LA1_0 = input.LA(1);

            if ( (LA1_0==WHERE) ) {
                alt1=1;
            }
            } finally {dbg.exitDecision(1);}

            switch (alt1) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:48:16: where
                    {
                    dbg.location(48,16);
                    pushFollow(FOLLOW_where_in_query181);
                    where6=where();

                    state._fsp--;

                    stream_where.add(where6.getTree());

                    }
                    break;

            }
            } finally {dbg.exitSubRule(1);}



            // AST REWRITE
            // elements: where, select, from
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 48:23: -> ^( QUERY from select ( where )? )
            {
                dbg.location(48,26);
                // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:48:26: ^( QUERY from select ( where )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(48,28);
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(QUERY, "QUERY"), root_1);

                dbg.location(48,34);
                adaptor.addChild(root_1, stream_from.nextTree());
                dbg.location(48,39);
                adaptor.addChild(root_1, stream_select.nextTree());
                dbg.location(48,46);
                // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:48:46: ( where )?
                if ( stream_where.hasNext() ) {
                    dbg.location(48,46);
                    adaptor.addChild(root_1, stream_where.nextTree());

                }
                stream_where.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        dbg.location(48, 53);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "query1");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "query1"

    public static class select_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "select"
    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:50:1: select : SELECT ( ( NAME | aggregate_funct ) ( ',' ( NAME | aggregate_funct ) )* | STAR ) ;
    public final SQL_grammarParser.select_return select() throws RecognitionException {
        SQL_grammarParser.select_return retval = new SQL_grammarParser.select_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SELECT7=null;
        Token NAME8=null;
        Token char_literal10=null;
        Token NAME11=null;
        Token STAR13=null;
        SQL_grammarParser.aggregate_funct_return aggregate_funct9 = null;

        SQL_grammarParser.aggregate_funct_return aggregate_funct12 = null;


        CommonTree SELECT7_tree=null;
        CommonTree NAME8_tree=null;
        CommonTree char_literal10_tree=null;
        CommonTree NAME11_tree=null;
        CommonTree STAR13_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "select");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(50, 1);

        try {
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:50:8: ( SELECT ( ( NAME | aggregate_funct ) ( ',' ( NAME | aggregate_funct ) )* | STAR ) )
            dbg.enterAlt(1);

            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:50:11: SELECT ( ( NAME | aggregate_funct ) ( ',' ( NAME | aggregate_funct ) )* | STAR )
            {
            root_0 = (CommonTree)adaptor.nil();

            dbg.location(50,17);
            SELECT7=(Token)match(input,SELECT,FOLLOW_SELECT_in_select110); 
            SELECT7_tree = (CommonTree)adaptor.create(SELECT7);
            root_0 = (CommonTree)adaptor.becomeRoot(SELECT7_tree, root_0);

            dbg.location(50,20);
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:50:20: ( ( NAME | aggregate_funct ) ( ',' ( NAME | aggregate_funct ) )* | STAR )
            int alt5=2;
            try { dbg.enterSubRule(5);
            try { dbg.enterDecision(5);

            int LA5_0 = input.LA(1);

            if ( (LA5_0==NAME||(LA5_0>=COUNT && LA5_0<=MAX)) ) {
                alt5=1;
            }
            else if ( (LA5_0==STAR) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(5);}

            switch (alt5) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:50:22: ( NAME | aggregate_funct ) ( ',' ( NAME | aggregate_funct ) )*
                    {
                    dbg.location(50,22);
                    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:50:22: ( NAME | aggregate_funct )
                    int alt2=2;
                    try { dbg.enterSubRule(2);
                    try { dbg.enterDecision(2);

                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==NAME) ) {
                        alt2=1;
                    }
                    else if ( ((LA2_0>=COUNT && LA2_0<=MAX)) ) {
                        alt2=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 0, input);

                        dbg.recognitionException(nvae);
                        throw nvae;
                    }
                    } finally {dbg.exitDecision(2);}

                    switch (alt2) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:50:23: NAME
                            {
                            dbg.location(50,23);
                            NAME8=(Token)match(input,NAME,FOLLOW_NAME_in_select117); 
                            NAME8_tree = (CommonTree)adaptor.create(NAME8);
                            adaptor.addChild(root_0, NAME8_tree);


                            }
                            break;
                        case 2 :
                            dbg.enterAlt(2);

                            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:50:30: aggregate_funct
                            {
                            dbg.location(50,30);
                            pushFollow(FOLLOW_aggregate_funct_in_select121);
                            aggregate_funct9=aggregate_funct();

                            state._fsp--;

                            adaptor.addChild(root_0, aggregate_funct9.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(2);}

                    dbg.location(50,47);
                    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:50:47: ( ',' ( NAME | aggregate_funct ) )*
                    try { dbg.enterSubRule(4);

                    loop4:
                    do {
                        int alt4=2;
                        try { dbg.enterDecision(4);

                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==25) ) {
                            alt4=1;
                        }


                        } finally {dbg.exitDecision(4);}

                        switch (alt4) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:50:48: ',' ( NAME | aggregate_funct )
                    	    {
                    	    dbg.location(50,51);
                    	    char_literal10=(Token)match(input,25,FOLLOW_25_in_select125); 
                    	    dbg.location(50,53);
                    	    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:50:53: ( NAME | aggregate_funct )
                    	    int alt3=2;
                    	    try { dbg.enterSubRule(3);
                    	    try { dbg.enterDecision(3);

                    	    int LA3_0 = input.LA(1);

                    	    if ( (LA3_0==NAME) ) {
                    	        alt3=1;
                    	    }
                    	    else if ( ((LA3_0>=COUNT && LA3_0<=MAX)) ) {
                    	        alt3=2;
                    	    }
                    	    else {
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 3, 0, input);

                    	        dbg.recognitionException(nvae);
                    	        throw nvae;
                    	    }
                    	    } finally {dbg.exitDecision(3);}

                    	    switch (alt3) {
                    	        case 1 :
                    	            dbg.enterAlt(1);

                    	            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:50:54: NAME
                    	            {
                    	            dbg.location(50,54);
                    	            NAME11=(Token)match(input,NAME,FOLLOW_NAME_in_select129); 
                    	            NAME11_tree = (CommonTree)adaptor.create(NAME11);
                    	            adaptor.addChild(root_0, NAME11_tree);


                    	            }
                    	            break;
                    	        case 2 :
                    	            dbg.enterAlt(2);

                    	            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:50:61: aggregate_funct
                    	            {
                    	            dbg.location(50,61);
                    	            pushFollow(FOLLOW_aggregate_funct_in_select133);
                    	            aggregate_funct12=aggregate_funct();

                    	            state._fsp--;

                    	            adaptor.addChild(root_0, aggregate_funct12.getTree());

                    	            }
                    	            break;

                    	    }
                    	    } finally {dbg.exitSubRule(3);}


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);
                    } finally {dbg.exitSubRule(4);}


                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:50:83: STAR
                    {
                    dbg.location(50,83);
                    STAR13=(Token)match(input,STAR,FOLLOW_STAR_in_select141); 
                    STAR13_tree = (CommonTree)adaptor.create(STAR13);
                    adaptor.addChild(root_0, STAR13_tree);


                    }
                    break;

            }
            } finally {dbg.exitSubRule(5);}


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        dbg.location(51, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "select");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "select"

    public static class aggregate_funct_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "aggregate_funct"
    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:52:1: aggregate_funct : ( COUNT | SUM | AVG | MIN | MAX ) '(' NAME ')' ;
    public final SQL_grammarParser.aggregate_funct_return aggregate_funct() throws RecognitionException {
        SQL_grammarParser.aggregate_funct_return retval = new SQL_grammarParser.aggregate_funct_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set14=null;
        Token char_literal15=null;
        Token NAME16=null;
        Token char_literal17=null;

        CommonTree set14_tree=null;
        CommonTree char_literal15_tree=null;
        CommonTree NAME16_tree=null;
        CommonTree char_literal17_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "aggregate_funct");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(52, 1);

        try {
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:53:2: ( ( COUNT | SUM | AVG | MIN | MAX ) '(' NAME ')' )
            dbg.enterAlt(1);

            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:53:4: ( COUNT | SUM | AVG | MIN | MAX ) '(' NAME ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            dbg.location(53,4);
            set14=(Token)input.LT(1);
            set14=(Token)input.LT(1);
            if ( (input.LA(1)>=COUNT && input.LA(1)<=MAX) ) {
                input.consume();
                root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set14), root_0);
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                dbg.recognitionException(mse);
                throw mse;
            }

            dbg.location(53,42);
            char_literal15=(Token)match(input,26,FOLLOW_26_in_aggregate_funct177); 
            dbg.location(53,45);
            NAME16=(Token)match(input,NAME,FOLLOW_NAME_in_aggregate_funct181); 
            NAME16_tree = (CommonTree)adaptor.create(NAME16);
            adaptor.addChild(root_0, NAME16_tree);

            dbg.location(53,53);
            char_literal17=(Token)match(input,27,FOLLOW_27_in_aggregate_funct183); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        dbg.location(54, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "aggregate_funct");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "aggregate_funct"

    public static class from_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "from"
    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:56:1: from : FROM NAME ( ',' NAME )* ;
    public final SQL_grammarParser.from_return from() throws RecognitionException {
        SQL_grammarParser.from_return retval = new SQL_grammarParser.from_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token FROM18=null;
        Token NAME19=null;
        Token char_literal20=null;
        Token NAME21=null;

        CommonTree FROM18_tree=null;
        CommonTree NAME19_tree=null;
        CommonTree char_literal20_tree=null;
        CommonTree NAME21_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "from");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(56, 1);

        try {
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:56:6: ( FROM NAME ( ',' NAME )* )
            dbg.enterAlt(1);

            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:56:8: FROM NAME ( ',' NAME )*
            {
            root_0 = (CommonTree)adaptor.nil();

            dbg.location(56,12);
            FROM18=(Token)match(input,FROM,FOLLOW_FROM_in_from195); 
            FROM18_tree = (CommonTree)adaptor.create(FROM18);
            root_0 = (CommonTree)adaptor.becomeRoot(FROM18_tree, root_0);

            dbg.location(56,14);
            NAME19=(Token)match(input,NAME,FOLLOW_NAME_in_from198); 
            NAME19_tree = (CommonTree)adaptor.create(NAME19);
            adaptor.addChild(root_0, NAME19_tree);

            dbg.location(56,19);
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:56:19: ( ',' NAME )*
            try { dbg.enterSubRule(6);

            loop6:
            do {
                int alt6=2;
                try { dbg.enterDecision(6);

                int LA6_0 = input.LA(1);

                if ( (LA6_0==25) ) {
                    alt6=1;
                }


                } finally {dbg.exitDecision(6);}

                switch (alt6) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:56:20: ',' NAME
            	    {
            	    dbg.location(56,23);
            	    char_literal20=(Token)match(input,25,FOLLOW_25_in_from201); 
            	    dbg.location(56,25);
            	    NAME21=(Token)match(input,NAME,FOLLOW_NAME_in_from204); 
            	    NAME21_tree = (CommonTree)adaptor.create(NAME21);
            	    adaptor.addChild(root_0, NAME21_tree);


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);
            } finally {dbg.exitSubRule(6);}


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        dbg.location(57, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "from");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "from"

    public static class where_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "where"
    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:59:1: where : WHERE and ;
    public final SQL_grammarParser.where_return where() throws RecognitionException {
        SQL_grammarParser.where_return retval = new SQL_grammarParser.where_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token WHERE22=null;
        SQL_grammarParser.and_return and23 = null;


        CommonTree WHERE22_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "where");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(59, 1);

        try {
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:59:7: ( WHERE and )
            dbg.enterAlt(1);

            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:59:9: WHERE and
            {
            root_0 = (CommonTree)adaptor.nil();

            dbg.location(59,14);
            WHERE22=(Token)match(input,WHERE,FOLLOW_WHERE_in_where217); 
            WHERE22_tree = (CommonTree)adaptor.create(WHERE22);
            root_0 = (CommonTree)adaptor.becomeRoot(WHERE22_tree, root_0);

            dbg.location(59,16);
            pushFollow(FOLLOW_and_in_where220);
            and23=and();

            state._fsp--;

            adaptor.addChild(root_0, and23.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        dbg.location(60, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "where");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "where"

    public static class and_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "and"
    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:62:1: and : clause ( 'AND' clause )* ;
    public final SQL_grammarParser.and_return and() throws RecognitionException {
        SQL_grammarParser.and_return retval = new SQL_grammarParser.and_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal25=null;
        SQL_grammarParser.clause_return clause24 = null;

        SQL_grammarParser.clause_return clause26 = null;


        CommonTree string_literal25_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "and");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(62, 1);

        try {
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:62:5: ( clause ( 'AND' clause )* )
            dbg.enterAlt(1);

            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:62:7: clause ( 'AND' clause )*
            {
            root_0 = (CommonTree)adaptor.nil();

            dbg.location(62,7);
            pushFollow(FOLLOW_clause_in_and230);
            clause24=clause();

            state._fsp--;

            adaptor.addChild(root_0, clause24.getTree());
            dbg.location(62,14);
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:62:14: ( 'AND' clause )*
            try { dbg.enterSubRule(7);

            loop7:
            do {
                int alt7=2;
                try { dbg.enterDecision(7);

                int LA7_0 = input.LA(1);

                if ( (LA7_0==28) ) {
                    alt7=1;
                }


                } finally {dbg.exitDecision(7);}

                switch (alt7) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:62:16: 'AND' clause
            	    {
            	    dbg.location(62,21);
            	    string_literal25=(Token)match(input,28,FOLLOW_28_in_and234); 
            	    dbg.location(62,23);
            	    pushFollow(FOLLOW_clause_in_and237);
            	    clause26=clause();

            	    state._fsp--;

            	    adaptor.addChild(root_0, clause26.getTree());

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);
            } finally {dbg.exitSubRule(7);}


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        dbg.location(63, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "and");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "and"

    public static class clause_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "clause"
    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:65:1: clause : ( ( NAME | literal ) op ( NAME | literal ) | ( NAME | literal ) IN '(' query1 ')' );
    public final SQL_grammarParser.clause_return clause() throws RecognitionException {
        SQL_grammarParser.clause_return retval = new SQL_grammarParser.clause_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME27=null;
        Token NAME30=null;
        Token NAME32=null;
        Token IN34=null;
        Token char_literal35=null;
        Token char_literal37=null;
        SQL_grammarParser.literal_return literal28 = null;

        SQL_grammarParser.op_return op29 = null;

        SQL_grammarParser.literal_return literal31 = null;

        SQL_grammarParser.literal_return literal33 = null;

        SQL_grammarParser.query1_return query136 = null;


        CommonTree NAME27_tree=null;
        CommonTree NAME30_tree=null;
        CommonTree NAME32_tree=null;
        CommonTree IN34_tree=null;
        CommonTree char_literal35_tree=null;
        CommonTree char_literal37_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "clause");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(65, 1);

        try {
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:65:8: ( ( NAME | literal ) op ( NAME | literal ) | ( NAME | literal ) IN '(' query1 ')' )
            int alt11=2;
            try { dbg.enterDecision(11);

            int LA11_0 = input.LA(1);

            if ( (LA11_0==NAME) ) {
                int LA11_1 = input.LA(2);

                if ( (LA11_1==IN) ) {
                    alt11=2;
                }
                else if ( ((LA11_1>=EQ && LA11_1<=GT_EQ)) ) {
                    alt11=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    dbg.recognitionException(nvae);
                    throw nvae;
                }
            }
            else if ( (LA11_0==29) ) {
                int LA11_2 = input.LA(2);

                if ( (LA11_2==NAME) ) {
                    int LA11_5 = input.LA(3);

                    if ( (LA11_5==29) ) {
                        int LA11_6 = input.LA(4);

                        if ( ((LA11_6>=EQ && LA11_6<=GT_EQ)) ) {
                            alt11=1;
                        }
                        else if ( (LA11_6==IN) ) {
                            alt11=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 11, 6, input);

                            dbg.recognitionException(nvae);
                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 5, input);

                        dbg.recognitionException(nvae);
                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 2, input);

                    dbg.recognitionException(nvae);
                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(11);}

            switch (alt11) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:65:10: ( NAME | literal ) op ( NAME | literal )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    dbg.location(65,10);
                    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:65:10: ( NAME | literal )
                    int alt8=2;
                    try { dbg.enterSubRule(8);
                    try { dbg.enterDecision(8);

                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==NAME) ) {
                        alt8=1;
                    }
                    else if ( (LA8_0==29) ) {
                        alt8=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 0, input);

                        dbg.recognitionException(nvae);
                        throw nvae;
                    }
                    } finally {dbg.exitDecision(8);}

                    switch (alt8) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:65:12: NAME
                            {
                            dbg.location(65,12);
                            NAME27=(Token)match(input,NAME,FOLLOW_NAME_in_clause252); 
                            NAME27_tree = (CommonTree)adaptor.create(NAME27);
                            adaptor.addChild(root_0, NAME27_tree);


                            }
                            break;
                        case 2 :
                            dbg.enterAlt(2);

                            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:65:19: literal
                            {
                            dbg.location(65,19);
                            pushFollow(FOLLOW_literal_in_clause256);
                            literal28=literal();

                            state._fsp--;

                            adaptor.addChild(root_0, literal28.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(8);}

                    dbg.location(65,30);
                    pushFollow(FOLLOW_op_in_clause259);
                    op29=op();

                    state._fsp--;

                    root_0 = (CommonTree)adaptor.becomeRoot(op29.getTree(), root_0);
                    dbg.location(65,32);
                    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:65:32: ( NAME | literal )
                    int alt9=2;
                    try { dbg.enterSubRule(9);
                    try { dbg.enterDecision(9);

                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==NAME) ) {
                        alt9=1;
                    }
                    else if ( (LA9_0==29) ) {
                        alt9=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 0, input);

                        dbg.recognitionException(nvae);
                        throw nvae;
                    }
                    } finally {dbg.exitDecision(9);}

                    switch (alt9) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:65:34: NAME
                            {
                            dbg.location(65,34);
                            NAME30=(Token)match(input,NAME,FOLLOW_NAME_in_clause264); 
                            NAME30_tree = (CommonTree)adaptor.create(NAME30);
                            adaptor.addChild(root_0, NAME30_tree);


                            }
                            break;
                        case 2 :
                            dbg.enterAlt(2);

                            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:65:42: literal
                            {
                            dbg.location(65,42);
                            pushFollow(FOLLOW_literal_in_clause269);
                            literal31=literal();

                            state._fsp--;

                            adaptor.addChild(root_0, literal31.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(9);}


                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:66:5: ( NAME | literal ) IN '(' query1 ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    dbg.location(66,5);
                    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:66:5: ( NAME | literal )
                    int alt10=2;
                    try { dbg.enterSubRule(10);
                    try { dbg.enterDecision(10);

                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==NAME) ) {
                        alt10=1;
                    }
                    else if ( (LA10_0==29) ) {
                        alt10=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 0, input);

                        dbg.recognitionException(nvae);
                        throw nvae;
                    }
                    } finally {dbg.exitDecision(10);}

                    switch (alt10) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:66:6: NAME
                            {
                            dbg.location(66,6);
                            NAME32=(Token)match(input,NAME,FOLLOW_NAME_in_clause279); 
                            NAME32_tree = (CommonTree)adaptor.create(NAME32);
                            adaptor.addChild(root_0, NAME32_tree);


                            }
                            break;
                        case 2 :
                            dbg.enterAlt(2);

                            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:66:13: literal
                            {
                            dbg.location(66,13);
                            pushFollow(FOLLOW_literal_in_clause283);
                            literal33=literal();

                            state._fsp--;

                            adaptor.addChild(root_0, literal33.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(10);}

                    dbg.location(66,24);
                    IN34=(Token)match(input,IN,FOLLOW_IN_in_clause286); 
                    IN34_tree = (CommonTree)adaptor.create(IN34);
                    root_0 = (CommonTree)adaptor.becomeRoot(IN34_tree, root_0);

                    dbg.location(66,29);
                    char_literal35=(Token)match(input,26,FOLLOW_26_in_clause289); 
                    dbg.location(66,31);
                    pushFollow(FOLLOW_query1_in_clause292);
                    query136=query1();

                    state._fsp--;

                    adaptor.addChild(root_0, query136.getTree());
                    dbg.location(66,41);
                    char_literal37=(Token)match(input,27,FOLLOW_27_in_clause294); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        dbg.location(67, 3);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "clause");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "clause"

    public static class literal_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "literal"
    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:68:1: literal : '\\'' name= NAME '\\'' -> LITERAL[$name] ;
    public final SQL_grammarParser.literal_return literal() throws RecognitionException {
        SQL_grammarParser.literal_return retval = new SQL_grammarParser.literal_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token name=null;
        Token char_literal38=null;
        Token char_literal39=null;

        CommonTree name_tree=null;
        CommonTree char_literal38_tree=null;
        CommonTree char_literal39_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_29=new RewriteRuleTokenStream(adaptor,"token 29");

        try { dbg.enterRule(getGrammarFileName(), "literal");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(68, 1);

        try {
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:68:9: ( '\\'' name= NAME '\\'' -> LITERAL[$name] )
            dbg.enterAlt(1);

            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:68:12: '\\'' name= NAME '\\''
            {
            dbg.location(68,12);
            char_literal38=(Token)match(input,29,FOLLOW_29_in_literal306);  
            stream_29.add(char_literal38);

            dbg.location(68,21);
            name=(Token)match(input,NAME,FOLLOW_NAME_in_literal310);  
            stream_NAME.add(name);

            dbg.location(68,27);
            char_literal39=(Token)match(input,29,FOLLOW_29_in_literal312);  
            stream_29.add(char_literal39);



            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 68:32: -> LITERAL[$name]
            {
                dbg.location(68,35);
                adaptor.addChild(root_0, (CommonTree)adaptor.create(LITERAL, name));

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        dbg.location(68, 49);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "literal");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "literal"

    public static class op_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "op"
    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:70:1: op : ( EQ | LS | GT | LS_EQ | GT_EQ ) ;
    public final SQL_grammarParser.op_return op() throws RecognitionException {
        SQL_grammarParser.op_return retval = new SQL_grammarParser.op_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set40=null;

        CommonTree set40_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "op");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(70, 1);

        try {
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:70:4: ( ( EQ | LS | GT | LS_EQ | GT_EQ ) )
            dbg.enterAlt(1);

            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:70:6: ( EQ | LS | GT | LS_EQ | GT_EQ )
            {
            root_0 = (CommonTree)adaptor.nil();

            dbg.location(70,6);
            set40=(Token)input.LT(1);
            if ( (input.LA(1)>=EQ && input.LA(1)<=GT_EQ) ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set40));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                dbg.recognitionException(mse);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        dbg.location(71, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "op");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "op"

    // Delegated rules


 

    public static final BitSet FOLLOW_query1_in_query59 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_query61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_query64 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_select_in_query177 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_from_in_query179 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_where_in_query181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SELECT_in_select110 = new BitSet(new long[]{0x0000000000003F80L});
    public static final BitSet FOLLOW_NAME_in_select117 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_aggregate_funct_in_select121 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_select125 = new BitSet(new long[]{0x0000000000003E80L});
    public static final BitSet FOLLOW_NAME_in_select129 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_aggregate_funct_in_select133 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_STAR_in_select141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_aggregate_funct154 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_aggregate_funct177 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NAME_in_aggregate_funct181 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_aggregate_funct183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FROM_in_from195 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NAME_in_from198 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_from201 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NAME_in_from204 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_WHERE_in_where217 = new BitSet(new long[]{0x0000000020000080L});
    public static final BitSet FOLLOW_and_in_where220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_clause_in_and230 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_and234 = new BitSet(new long[]{0x0000000020000080L});
    public static final BitSet FOLLOW_clause_in_and237 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_NAME_in_clause252 = new BitSet(new long[]{0x00000000003E0000L});
    public static final BitSet FOLLOW_literal_in_clause256 = new BitSet(new long[]{0x00000000003E0000L});
    public static final BitSet FOLLOW_op_in_clause259 = new BitSet(new long[]{0x0000000020000080L});
    public static final BitSet FOLLOW_NAME_in_clause264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_clause269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_clause279 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_literal_in_clause283 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_IN_in_clause286 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_clause289 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_query1_in_clause292 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_clause294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_literal306 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NAME_in_literal310 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_literal312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_op327 = new BitSet(new long[]{0x0000000000000002L});

}