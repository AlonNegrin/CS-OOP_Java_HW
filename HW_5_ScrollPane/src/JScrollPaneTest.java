/**
 * @author Ronny Sivan  (ronny.sivan@gmail.com)
 *
 * @date 9 Jun 2022
 * 
 */

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

/**
 * JScrollPaneTest
 *
 */
public class JScrollPaneTest
{
   /**
    * main - 
    *
    * @param args
    */
   public static void main( String[] args )
   {
      JTextArea jta = new JTextArea();
      String text = "’Twas brillig, and the slithy toves\n"
               + "      Did gyre and gimble in the wabe:\n"
               + "All mimsy were the borogoves,\n"
               + "      And the mome raths outgrabe.\n"
               + "\n"
               + "“Beware the Jabberwock, my son!\n"
               + "      The jaws that bite, the claws that catch!\n"
               + "Beware the Jubjub bird, and shun\n"
               + "      The frumious Bandersnatch!”\n"
               + "\n"
               + "He took his vorpal sword in hand;\n"
               + "      Long time the manxome foe he sought—\n"
               + "So rested he by the Tumtum tree\n"
               + "      And stood awhile in thought.\n"
               + "\n"
               + "And, as in uffish thought he stood,\n"
               + "      The Jabberwock, with eyes of flame,\n"
               + "Came whiffling through the tulgey wood,\n"
               + "      And burbled as it came!\n"
               + "\n"
               + "One, two! One, two! And through and through\n"
               + "      The vorpal blade went snicker-snack!\n"
               + "He left it dead, and with its head\n"
               + "      He went galumphing back.\n"
               + "\n"
               + "“And hast thou slain the Jabberwock?\n"
               + "      Come to my arms, my beamish boy!\n"
               + "O frabjous day! Callooh! Callay!”\n"
               + "      He chortled in his joy.\n"
               + "\n"
               + "’Twas brillig, and the slithy toves\n"
               + "      Did gyre and gimble in the wabe:\n"
               + "All mimsy were the borogoves,\n"
               + "      And the mome raths outgrabe.";
      jta.setText( text );      
      JPanel jp = new JPanel();
      jp.setBackground( Color.yellow );
      jp.add( jta );
      MyScrollPane msp = new MyScrollPane( jp);

      int actualWidth = 200;
      int actualHeight = 400;
      JFrame frame = new JFrame( "JScrollPane Demo" );
      frame.setPreferredSize( new Dimension( actualWidth, actualHeight ) );
      frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      frame.add( msp );
      frame.pack();
      frame.setVisible( true );
   }

}
