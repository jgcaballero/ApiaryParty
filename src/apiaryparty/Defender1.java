package apiaryparty;

import java.util.Random;

public class Defender1 extends Defender {

	Random r;
	
	   public Defender1(String graphFile)
	   {
	        super("Defender1",graphFile);
	   }

	   @Override
		public void initialize() {
		   r = new Random();
		}

		@Override
		public void actionResult(boolean actionSuccess) {
			
		}

		@Override
		public DefenderAction makeAction() {
			Random r = new Random();
			int honeyNode = r.nextInt(net.getAvailableNodes().size());
			int honeypotCost = honeypotCost(honeyNode);
	        int node = r.nextInt(net.getSize());

			System.out.println("WHAT IS THIS HONEYPOT COST FAM?" + honeypotCost+  "=======================================");

			if(getBudget() > honeypotCost)
				return new DefenderAction(DefenderActionType.HONEYPOT, honeyNode);
			else if(getBudget() > Parameters.FIREWALL_RATE)
				return new DefenderAction(DefenderActionType.FIREWALL, node);
			else if(getBudget() > Parameters.STRENGTHEN_RATE)
				return new DefenderAction(DefenderActionType.STRENGTHEN, node);
			else
				return new DefenderAction(DefenderActionType.END_TURN);

			
		}


}
