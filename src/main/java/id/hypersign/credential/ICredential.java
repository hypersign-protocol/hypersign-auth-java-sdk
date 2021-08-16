package id.hypersign.credential;

public interface ICredential {
    public void generateCredential();

    public void signCredential();

    public void verifyCredential();

    public String verifyPresentation(String challenge) throws Exception;

}
