public class UsageException extends Exception {

    /**
     * The UsageException class is used to suppress the stack trace and display the usage
     * of the program.
     */
    public UsageException(String message) {
        super(message, null, true, false);
    }
}
