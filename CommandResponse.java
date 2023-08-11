public interface CommandResponse {
    /**
     * @param commandData The command data.
     * @return
     */
    public byte[] applicationBlock(byte[] commandData);
    /**
     * @param commandData The command data.
     * @return
     */
    public byte[] applicationUnblockbyte(byte[] commandData);
    /**
     * @param commandData The command data.
     * @return
     */
    public byte[] cardBlock(byte[] commandData);
    /**
     * @param commandData The command data.
     * @return
     */
    public byte[] externalAuthenticate(byte[] commandData);
    /**
     * @param p1 The P1 byte is the first parameter of the command.
     * @param commandData The command data.
     * @return
     */
    public byte[] generateApplicationCryptogram(byte p1, byte[] commandData);
    /**
     * @return
     */
    public byte[] getChallenge();
    /**
     * @param p1 The P1 byte is the first parameter of the command.
     * @param p2 The P2 byte is the second parameter of the command.
     * P1 P2 '9F36', '9F13', '9F17', '9F4F', 'BF4C' or 'BF4D
     * @return
     */
    public byte[] getData(byte p1, byte p2);
    /**
     * @param commandData The command data.
     * @return
     */
    public byte[] getProcessingOptions(byte[] commandData);
    /**
     * @param commandData The command data.
     * @return
     */
    public byte[] internalAuthenticate(byte[] commandData);
    /**
     * @param p1 The P1 byte is the first parameter of the command.
     * @param p2 The P2 byte is the second parameter of the command.
     * @return
     */
    public byte[] pinChange(byte p1, byte p2);
    /**
     * @param p1 The P1 byte is the first parameter of the command.
     * @param p2 The P2 byte is the second parameter of the command.
     * @return
     */
    public byte[] readRecord(byte p1, byte p2);
    /**
     * @param p2 The P2 byte is the second parameter of the command.
     * @param commandData The command data.
     * @return
     */
    public byte[] select(byte p2, byte[] commandData);
    /**
     * @param p2 The P2 byte is the second parameter of the command.
     * @param commandData The command data.
     * @return
     */
    public byte[] verify(byte p2, byte[] commandData);
}
