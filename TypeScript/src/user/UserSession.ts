import CollaboratorCallException from "../exception/CollaboratorCallException";
import User from "./User";

class UserSession {
    public getLoggedUser(): User {
        throw new CollaboratorCallException(
            "UserSession.getLoggedUser() should not be called in an unit test",
        );
    }
}

export default new UserSession();
