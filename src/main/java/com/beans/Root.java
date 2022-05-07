package com.beans;

public class Root {
    private String name;
    private Commit commit;
    private Boolean _protected;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Commit getCommit() {
        return commit;
    }
    public void setCommit(Commit commit) {
        this.commit = commit;
    }
    public Boolean getProtected() {
        return _protected;
    }
    public void setProtected(Boolean _protected) {
        this._protected = _protected;
    }
}
