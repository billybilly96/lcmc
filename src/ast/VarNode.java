package ast;

import lib.FOOLlib;

public class VarNode implements Node, DecNode {

	private String id;
	private Node type;
	private Node exp;

	public VarNode(String i, Node t, Node e) {
		id = i;
		type = t; 
		exp = e;
	}
	
	public Node getSymType() {
		return type; 
	}

	public String toPrint(String s) {
		return s + "Var:" + id + "\n" + type.toPrint(s + "  ") + exp.toPrint(s + "  "); 
	}

	public Node typeCheck() {
		if (!FOOLlib.isSubtype(exp.typeCheck(), type)) {
			System.out.println("Incompatible value for variable: " + id);
			System.exit(0);  
		}
		return null;
	}

	public String codeGeneration() {
		return exp.codeGeneration();
	}

}  