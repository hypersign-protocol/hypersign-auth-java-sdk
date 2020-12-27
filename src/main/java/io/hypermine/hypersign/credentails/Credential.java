package io.hypermine.hypersign.credentails;

public interface Credential {
    public void generateCredential();

    public void signCredential();

    public void verifyCredential();

}
