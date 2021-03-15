package objs;

import models.TokenDTO;

import java.util.ArrayList;

public class Token {
    ArrayList<TokenDTO> tokens=new ArrayList<TokenDTO>();
    public Token(){

    }
    public void add(String s){
        TokenDTO tokenCurrent=null;
        for(TokenDTO token:this.tokens){
            if (token.token.equals(s)){
                token.counter+=1;
                tokenCurrent=token;
                break;
            }
        }
        if (tokenCurrent==null){
            tokens.add(new TokenDTO(s,1));
        }
    }
    public int getLength(){
        return tokens.size();
    }
    public int countTotal(){
        int total=0;
        for(TokenDTO token:this.tokens){
            total+=token.counter;
        }
        return  total;
    }

    @Override
    public String toString() {
        return "Token{" +
                "tokens=" + tokens +
                '}';
    }
}
