package com.bbs.domain;


public class BbsWordTable {

  private long wordId;
  private String word;//敏感词
  private long status;//是否启用


  public long getWordId() {
    return wordId;
  }

  public void setWordId(long wordId) {
    this.wordId = wordId;
  }


  public String getWord() {
    return word;
  }

  public void setWord(String word) {
    this.word = word;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }

}
