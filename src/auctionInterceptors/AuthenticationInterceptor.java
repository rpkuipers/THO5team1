package auctionInterceptors;

import java.util.Map;

import auctionAware.UserAware;
import auctionDomain.User;
import auctionService.IAuctionService;
import auctionService.ServiceProvider;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

@SuppressWarnings("serial")
public class AuthenticationInterceptor implements Interceptor {

	public void destroy() {
	}

	public void init() {
	}

	public String intercept( ActionInvocation actionInvocation ) throws Exception {
		IAuctionService ias = ServiceProvider.getAuctionService();
		
		@SuppressWarnings("rawtypes")
		Map session = actionInvocation.getInvocationContext().getSession();
		
		User user = (User) session.get("user");
												
		if (user == null) {
			ias.getSearchResult().clear();				// Delete SearchResult. (Temporary solution)
		    return Action.LOGIN;
		} 
		else {
		    Action action = (Action) actionInvocation.getAction();

			ias.getSearchResult().clear();				// Delete SearchResult. (Temporary solution)
		    if (action instanceof UserAware) {			// If the action = UserAware
		        ((UserAware)action).setUser(user);		// set the user (as said in the user aware class.
		    }
		    
		    return actionInvocation.invoke();
		}
	}
}
