package space.bindingModel;


import javax.validation.constraints.NotNull;

public class FunFactBindingModel {
    @NotNull
    private String content;

    public String getContent() { return content; }

    public  void setContent(String content) { this.content = content; }
}
