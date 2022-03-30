import lk.opensource.ramithj.flags.FlagReader;

public class Main {

    public static void main(String[] arg) throws Exception{

       byte[] content = FlagReader.getFlag("us");
       System.out.println("done");
    }
}
