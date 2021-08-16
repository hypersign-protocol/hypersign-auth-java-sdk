package id.hypersign.credential;

import id.hypersign.api.utils.HttpClientUtil;

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
    public String verifyPresentation(String challenge) throws Exception {
        System.out.println("Challenge is: " + challenge);
        String authserver = "https://stage.hypermine.in/hsauth/hs/api/v2/auth";
        String userdata = HttpClientUtil.authServerCall(challenge, authserver);
     return userdata;
    }
}
