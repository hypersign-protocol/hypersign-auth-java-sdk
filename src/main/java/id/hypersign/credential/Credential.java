package id.hypersign.credential;

public class Credential implements ICredential {

    @Override
    public void generateCredential() {

    }

    @Override
    public void signCredential() {

    }

    @Override
    public void verifyCredential() {

    }

    @Override
    public Object verifyPresentation() {
        //Call /hs/api/v1/auth api of hs_auth_server by passing VP sent from user.
        // And get the actual user data as a response
     return null;
    }
}
