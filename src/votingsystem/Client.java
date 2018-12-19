/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package votingsystem;
import java.net.FileNameMap;
import java.rmi.Naming;
import sun.java2d.loops.MaskFill;
/**
 *
 * @author pro
 */
public class Client {
    
    public static void main(String args[]) {
	 	try {
			 VotingInterface vi=(VotingInterface)Naming.lookup("rmi://localhost:5099/voting");
                         vi.createCompetitor("mafi", 21,"student", "software enginnering 4th year student", 1);
		}
		catch(Exception e){
			System.out.println("Client Exception: "+e);
		}
	}
    
    
    
}
