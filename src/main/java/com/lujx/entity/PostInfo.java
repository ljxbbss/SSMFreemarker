package com.lujx.entity;

public class PostInfo {
    private Integer id;

    private String postName;

    private String postCode;

    private String postDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName == null ? null : postName.trim();
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode == null ? null : postCode.trim();
    }

    public String getPostDesc() {
        return postDesc;
    }

    public void setPostDesc(String postDesc) {
        this.postDesc = postDesc == null ? null : postDesc.trim();
    }
}