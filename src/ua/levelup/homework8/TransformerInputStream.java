package ua.levelup.homework8;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TransformerInputStream extends FilterInputStream {
    public char from;
    public char to;

    TransformerInputStream(InputStream in, char from, char to){
        super(in);
        this.from=from;
        this.to=to;
    }
    public int characterReplacement(int ch)  {
            if (ch==from){
                ch=to;
            }
        return ch;
    }


    public int read () throws IOException {
        int ch=super.read();
       return ch == -1 ? ch : characterReplacement(ch);
    }
    public static void main(String[] args) {
        try {TransformerInputStream tis=new TransformerInputStream(new TransformerInputStream(System.in, 'e', 'r'),'w','t');
            int read;
            while ((read=tis.read())!=-1){
                System.out.print((char)read);
            }

        }catch (Exception e){
            System.err.println(e.getMessage());
        }

    }
}
