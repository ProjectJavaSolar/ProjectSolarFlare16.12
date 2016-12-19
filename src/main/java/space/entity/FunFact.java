package space.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "funfacts")
public class FunFact {
    private Integer id;

    private String content;

  //  private Set<FunFact> funFacts;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Column(columnDefinition = "text", nullable = false)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public FunFact (String content){
        this.content = content;
    }

    public FunFact() { }

    @Transient
    public String getSummary(){
        return this.getContent();
    }
 //  @JoinColumn(table = "funfacts")
 //  public Set<FunFact> getFunFact() { return funFacts; }
}
