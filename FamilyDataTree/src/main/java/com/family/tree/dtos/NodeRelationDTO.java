package com.family.tree.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NodeRelationDTO {
    private String source;
    private String target;
    private String type;
    private String label;
    
    public NodeRelationDTO() {};
    
	public NodeRelationDTO(String source, String target, String type, String label) {
		super();
		this.source = source;
		this.target = target;
		this.type = type;
		this.label = label;
	}
	public String getSource() {
		return source;
	}
	public String getTarget() {
		return target;
	}
	public String getType() {
		return type;
	}
	public String getLabel() {
		return label;
	}
    
}