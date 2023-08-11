import java.util.ArrayList;
import java.util.List;

public class Commands implements CommandResponse {
     @Override
     public byte[] applicationBlock(byte[] commandData) {
          Iso7816Defs.Cla cla = Iso7816Defs.Cla.Cla8x;
          Iso7816Defs.Ins ins;
          byte p1, p2;
          return new byte[0];
     }

     @Override
     public byte[] applicationUnblockbyte(byte[] commandData) {
          return new byte[0];
     }

     @Override
     public byte[] cardBlock(byte[] commandData) {
          return new byte[0];
     }

     @Override
     public byte[] externalAuthenticate(byte[] commandData) {
          return new byte[0];
     }

     @Override
     public byte[] generateApplicationCryptogram(byte p1, byte[] commandData) {
          return new byte[0];
     }

     @Override
     public byte[] getChallenge() {
          return new byte[0];
     }

     @Override
     public byte[] getData(byte p1, byte p2) {
          return new byte[0];
     }

     @Override
     public byte[] getProcessingOptions(byte[] commandData) {
          return new byte[0];
     }

     @Override
     public byte[] internalAuthenticate(byte[] commandData) {
          return new byte[0];
     }

     @Override
     public byte[] pinChange(byte p1, byte p2) {
          return new byte[0];
     }

     @Override
     public byte[] readRecord(byte p1, byte p2) {
          return new byte[0];
     }

     @Override
     public byte[] select(byte p2, byte[] commandData) {
     APDUCommand apdu = new APDUCommand();
     apdu.ApduCommand(Iso7816Defs.Cla.Cmd0x.getValue(),
             Iso7816Defs.Ins.SELECT.getValue(),
             (byte) 0x04, p2, commandData);
     apdu.serialize();
          return new byte[0];
     }

     @Override
     public byte[] verify(byte p2, byte[] commandData) {
          return new byte[0];
     }
}
