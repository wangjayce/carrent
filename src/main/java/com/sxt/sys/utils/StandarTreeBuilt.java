package com.sxt.sys.utils;

import java.util.ArrayList;
import java.util.List;

public class StandarTreeBuilt {
	
	public static List<TreeNote> builtCombotreeJson(List<TreeNote> treeNotes,Integer rootPid){
		List<TreeNote> notes = new ArrayList<TreeNote>();
		for (TreeNote treeNote1 : treeNotes) {
			if(treeNote1.getPid()==rootPid){
				notes.add(treeNote1);
			}
			for (TreeNote treeNote2 : treeNotes) {
				if(treeNote2.getPid()==treeNote1.getId()){
					treeNote1.getChildren().add(treeNote2);
				}
			}
		}	
		return notes;
		
		
		
	}

}
