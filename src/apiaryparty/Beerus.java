package apiaryparty;

import java.util.Random;

public class Beerus extends Attacker{
	
    private final static String attackerName = "Beerus";
    public Random r;


    public Beerus(String defenderName, String graphFile) {
		super(attackerName, defenderName, graphFile);
	}
    
	public Beerus() {
		super(attackerName);
	}
	
	protected void initialize(){
		r = new Random();
	}

	@Override
	public AttackerAction makeAction() {
		Random r = new Random();
        if(availableNodes.size()==0)
            return new AttackerAction(AttackerActionType.INVALID,0);
		int nodeID = availableNodes.get(r.nextInt(availableNodes.size())).getNodeID();
		int move = r.nextInt(4);
		AttackerActionType type;
		if(move == 0)
			type = AttackerActionType.ATTACK;
		else if(move == 1)
			type = AttackerActionType.SUPERATTACK;
		else if(move == 2)
			type = AttackerActionType.PROBE_POINTS;
		else if(move == 3)
			type = AttackerActionType.PROBE_HONEYPOT;
		else
			type = AttackerActionType.INVALID;
		return new AttackerAction(type, nodeID);
	}
	
	@Override
	protected void result(Node lastNode) {
		// TODO Auto-generated method stub
		
	}

}
