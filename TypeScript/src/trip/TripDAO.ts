import CollaboratorCallException from "../exception/CollaboratorCallException";
import User from "../user/User";

export default class TripDAO {
    public static findTripsByUser(user: User): User[] {
        throw new CollaboratorCallException(
            "TripDAO should not be invoked on an unit test.");
    }
}
