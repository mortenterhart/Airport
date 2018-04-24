package configuration;

public enum Configuration {
    instance;

    public String userDirectory = System.getProperty("user.dir");
    public String fileSeparator = System.getProperty("file.separator");
    public String commonPathToJavaArchive = buildJarPath();

    public String lineSeparator = System.getProperty("line.separator");
    public String logFileDirectory = userDirectory + fileSeparator + "log" + fileSeparator;
    public String logFile = logFileDirectory + "A380.log";

    public String dataDirectory = userDirectory + fileSeparator + "data" + fileSeparator;
    public String databaseFile = dataDirectory + "flightRecorderA380.db";

    /**
     * Builds the path to the jar archives depending on the current user directory.
     *
     * @return the correct path to the components folder.
     */
    private String buildJarPath() {
        if (userDirectory.endsWith("main-application")) {
            return userDirectory + fileSeparator + "components";
        }
        return userDirectory + fileSeparator + "main-application" + fileSeparator + "components";
    }
}
