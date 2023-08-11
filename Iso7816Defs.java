import kotlin.ParameterName;

public interface Iso7816Defs {
    /**
     * ApduCommand.
     *
     * @param cla The CLA byte represents the command class.
     * @param ins The INS byte represents the command instruction.
     * @param p1 The P1 byte is the first parameter of the command.
     * @param p2 The P2 byte is the second parameter of the command.
     * @param commandData The command data.
     * @return The command response.
     */
    public void ApduCommand(byte cla, byte ins, byte p1, byte p2, byte[] commandData);
    public void ApduResponse(byte[] response);
    public enum Cla {
        Cmd0x((byte) 0x00),
        CmdAx((byte) 0xA0),
        Cla8x((byte) 0x80),
        Cla9x((byte) 0x90),
        ClaEx((byte) 0xE0);

        private final byte value;

        Cla(byte value) {
            this.value = value;
        }

        public byte getValue() {
            return value;
        }
    }
    public enum Ins {
        APPLICATION_BLOCK((byte) 0x1E),
        APPLICATION_UNBLOCK((byte) 0x18),
        CARD_BLOCK((byte) 0x16),
        EXTERNAL_AUTHENTICATE((byte) 0x82),
        GENERATE_APPLICATION_CRYPTOGRAM((byte) 0xAE),
        GET_CHALLENGE((byte) 0x84),
        GET_DATA((byte) 0xCA),
        GET_PROCESSING_OPTIONS((byte) 0xA8),
        INTERNAL_AUTHENTICATE((byte) 0x88),
        PERSONAL_IDENTIFICATION_NUMBER((byte) 0x24),
        READ_RECORD((byte) 0xB2),
        SELECT((byte) 0xA4),
        VERIFY((byte) 0x20),
        RFU_PAYMENT_SYSTEMS_START((byte) 0xD0), // Placeholder for RFU values
        RFU_PAYMENT_SYSTEMS_END((byte) 0xFF),   // Placeholder for RFU values
        RFU_MANUFACTURERS_START((byte) 0xE0),   // Placeholder for RFU values
        RFU_MANUFACTURERS_END((byte) 0xEF),     // Placeholder for RFU values
        RFU_ISSUERS_START((byte) 0xF0),         // Placeholder for RFU values
        RFU_ISSUERS_END((byte) 0xFF);           // Placeholder for RFU values

        private final byte value;

        Ins(byte value) {
            this.value = value;
        }

        public byte getValue() {
            return value;
        }
    }
    public enum Sw1 {
        Sw1_0x((byte) 0x90), // Normal processing
        Sw1_62((byte) 0x62), // Warning processing
        Sw1_63((byte) 0x63), // Warning processing
        Sw1_68((byte) 0x68), // Checking errors
        Sw1_69((byte) 0x69), // Checking errors
        Sw1_6A((byte) 0x6A); // Checking errors

        private final byte value;

        Sw1(byte value) {
            this.value = value;
        }

        public byte getValue() {
            return value;
        }
    }
    public enum Sw2 {
        Sw2_0x((byte) 0x00),
        Sw2_Cx((byte) 0xC0),
        Sw2_81((byte) 0x81),
        Sw2_82((byte) 0x82),
        Sw2_83((byte) 0x83),
        Sw2_84((byte) 0x84),
        Sw2_85((byte) 0x85);

        private final byte value;

        Sw2(byte value) {
            this.value = value;
        }

        public byte getValue() {
            return value;
        }
    }
}
