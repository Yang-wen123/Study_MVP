package com.example.study_mvp.Bean;

public class Vocabulary {
    private String Character;
    private String Words;
    private String Spell;
    private String Paraphrase;

    public Vocabulary(String character, String words, String spell, String paraphrase) {
        super();
        Character=character;
        Words=words;
        Spell=spell;
        Paraphrase=paraphrase;
    }

    public String getCharacter(){
        return Character;
    }
    public void setCharacter(String character){
        this.Character=character;
    }
    public String getWords(){
        return Words;
    }
    public void setWords(String words){
        this.Words=words;
    }
    public String getSpell(){
        return Spell;
    }
    public void setSpell(String spell){
        this.Spell=spell;
    }
    public String getParaphrase(){
        return Paraphrase;
    }
    public void setParaphrase(String paraphrase){
        this.Paraphrase=paraphrase;
    }
    @Override
    public String toString() {
        return this.getCharacter() + "\n" +
                this.getWords() + "\n" +
                this.getSpell() + "\n" +
                this.getParaphrase() + "\n";
    }
}
