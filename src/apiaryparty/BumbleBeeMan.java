package apiaryparty;

import java.util.Random;

/**
 * Example attacker agent.
 * IMPORTANT NOTE: 	Your attacker object will be recreated for every action. Because of this,
 * 					model your Attacker to only make a decision on the current information. Do
 * 					not try to use variables that will carry on in to the next makeSingleAction()
 * 
 * Make use of the three protected variables inherited from Attacker. These variables include:
 * protected ArrayList&lt;Node&gt; capturedNodes - a list of the already captured nodes
 * protected ArrayList%lt;Node%gt; availableNodes - a list of the available nodes for attacking and probing.
 * protected int budget - the current budget of the Attacker. Be careful that your next move will not cost more than your budget.
 * 
 * @author Oscar Veliz
 */
public class BumbleBeeMan extends Attacker {

    private final static String attackerName = "BumbeBeeMan";
    
    public Random r;

    /**
     * Constructor
     * @param defenderName defender's name
     * @param graphFile graph to read
     */
	public BumbleBeeMan(String defenderName, String graphFile) {
		super(attackerName, defenderName, graphFile);
	}
	
	/**
	 * default constructor
	 */
	public BumbleBeeMan(){
		super(attackerName);
	}
	
	/**
	 * If you need to initialize anything, do it  here
	 */
	@Override
	protected void initialize(){
		r = new Random();
	}


	/**
	 * This is where your logic goes
	 * @return the action your attacker wants to do
	 */
	@Override
	public AttackerAction makeAction() {
        if(availableNodes.size()==0)
            return new AttackerAction(AttackerActionType.INVALID,0);
		int nodeID = availableNodes.get(r.nextInt(availableNodes.size())).getNodeID();
		return new AttackerAction(AttackerActionType.SUPERATTACK, nodeID);
	}

	/**
	 * The result of your action is updated here if you want to do anything with it. The network will be updated anyway.
	 * @param lastNode the node if successfully attacked
	 */
	@Override
	protected void result(Node lastNode) {
		// TODO Auto-generated method stub
		
	}
}
