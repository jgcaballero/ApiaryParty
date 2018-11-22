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
            return new AttackerAction(AttackerActionType.END_TURN, 0);
		int nodeID = availableNodes.get(r.nextInt(availableNodes.size())).getNodeID();
		
		for(Node x: availableNodes)
		{
			if (x.getSv() == -1 ) {
				nodeID = x.getNodeID();
				return new AttackerAction(AttackerActionType.PROBE_POINTS, nodeID);
			}			
			if(x.getPv() == -1) {
				nodeID = x.getNodeID();
				return new AttackerAction(AttackerActionType.PROBE_POINTS, nodeID);
			}
			if(x.knowsHoneyPot() == false) {
				nodeID = x.getNodeID();
				return new AttackerAction(AttackerActionType.PROBE_HONEYPOT, nodeID);
			}
			if(x.getPv() != -1 && x.getSv() != 1) {
				if(x.getSv() < 17 && !x.isHoneyPot()) {
					nodeID = x.getNodeID();
					return new AttackerAction(AttackerActionType.ATTACK, nodeID);
				} else if (x.getSv() >= 18 && !x.isHoneyPot())
					return new AttackerAction(AttackerActionType.SUPERATTACK, nodeID); 
			}
			if(availableNodes.size()==0)
	            return new AttackerAction(AttackerActionType.END_TURN, 0);

		}
		
		return new AttackerAction(AttackerActionType.END_TURN, nodeID); 

		
	}
	
	@Override
	protected void result(Node lastNode) {
		// TODO Auto-generated method stub
		
	}

}
