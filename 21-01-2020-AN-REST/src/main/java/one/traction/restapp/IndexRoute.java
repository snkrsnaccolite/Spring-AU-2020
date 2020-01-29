package one.traction.restapp;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/")
public class IndexRoute {
	@GET
	@Produces("application/json")
	public String[] getAll() {
		return DataStore.users.toArray(new String[DataStore.users.size()]);
	}

	@GET
	@Path("{index: \\d+}")
	@Produces("application/json")
	public String getByIndex(@PathParam("index") Integer index) {
		if (DataStore.users.size() <= index) {
			return "";
		}
		return DataStore.users.get(index);
	}

	@PUT
	@Produces("application/json")
	public String[] create(String name) {
		DataStore.users.add(name);
		return DataStore.users.toArray(new String[DataStore.users.size()]);
	}

	@DELETE
	@Produces("application/json")
	public String[] delete(String name) {
		DataStore.users.remove(name);
		return DataStore.users.toArray(new String[DataStore.users.size()]);
	}
}
