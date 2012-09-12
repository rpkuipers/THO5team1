package veilingService;

public class ServiceProvider {
	private static IVeilingService biebService = new VeilingService();
	public static IVeilingService getBiebService() {
		return biebService;
	}
}
