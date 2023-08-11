import java.util.ArrayList;
import java.util.List;

public class APDUCommand implements Iso7816Defs{
    private byte CLA, INS, P1, P2, Le, SW1, SW2;
    private byte[] CommandData, ResponseData;
    APDUCommand() {};
    @Override
    public void ApduCommand(byte cla, byte ins, byte p1, byte p2, byte[] commandData) {

        if (commandData != null && commandData.length > 255)
            {
                //TODO
            }
        CLA = cla;
        INS = ins;
        P1 = p1;
        P2 = p2;
        CommandData = commandData;
        Le = (byte) commandData.length;
    }
    public byte[] serialize() {
    List<Byte> result = new ArrayList<>();

    result.add(CLA);
    result.add(INS);
    result.add(P1);
    result.add(P2);

    if (Le != 0x00 && CommandData != null) {
        result.add((byte) CommandData.length);
        for (byte b : CommandData) {
            result.add(b);
        }
    }

    byte[] serializedArray = new byte[result.size()];
    for (int i = 0; i < result.size(); i++) {
        serializedArray[i] = result.get(i);
    }

    return serializedArray;
}

    public void deserialize(byte[] input) {
        CLA = input[0];
        INS = input[1];
        P1 = input[2];
        P2 = input[3];

        int length = input[4];
        CommandData = new byte[length];
        System.arraycopy(input, 5, CommandData, 0, CommandData.length);

        if (5 + CommandData.length < input.length) {
            Le = input[5 + CommandData.length];
        }
    }

    @Override
    public void ApduResponse(byte[] response) {

        if (response.length < 2) {
            throw new IllegalStateException("APDU response must be at least 2 bytes");
        }
        ResponseData = new byte[response.length - 2];
        System.arraycopy(response, 0, ResponseData, 0, ResponseData.length);

        SW1 = response[response.length - 2];
        SW2 = response[response.length - 1];
    }
    public byte[] getSW12() {
        return new byte[] { SW1, SW2 };
    }
    private short getSW() {
    return (short) (((short) (SW1 & 0xFF) << 8) | (short) (SW2 & 0xFF));
}

    public String getSWTranslation() {
        switch (getSW()) {
            case (short) 0x9000:
                return "Success";
            case 0x6700:
                return "Incorrect length or address range error";
            case 0x6800:
                return "The requested function is not supported by the card";
            case 0x6200:
                return "State of non-volatile memory unchanged; selected file invalidated";
            case 0x6300:
                return "State of non-volatile memory changed; authentication failed";
            case 0x63C0:
                return "State of non-volatile memory changed; counter provided by " + (SW2 & 0x0F);
            case 0x6883:
                return "Last command of chain was expected but not received";
            case 0x6884:
                return "Command chaining not supported";
            case 0x6983:
                return "Command not allowed; authentication method blocked";
            case 0x6984:
                return "Command not allowed; referenced data invalidated";
            case 0x6985:
                return "Command not allowed; conditions of use not satisfied";
            case 0x6A81:
                return "Wrong parameter(s) P1 P2; function not supported";
            case 0x6A82:
                return "Wrong parameter(s) P1 P2; file not found";
            case 0x6A83:
                return "Wrong parameter(s) P1 P2; record not found";
            case 0x6A88:
                return "Referenced data (data objects) not found";
            default:
                return "Unknown";
    }
}

}
