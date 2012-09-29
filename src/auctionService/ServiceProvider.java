package auctionService;

public class ServiceProvider {
		private static IAuctionService auctionService = new AuctionService();
		public static IAuctionService getAuctionService() {
			return auctionService;
		}
}
