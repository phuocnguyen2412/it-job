package models.bean;

public class SkillRecruitment {
    private int id;
    private int recruitmentId;
    private String skill;

    public SkillRecruitment() {}

    public SkillRecruitment(int id, int recruitmentId, String skill) {
        this.id = id;
        this.recruitmentId = recruitmentId;
        this.skill = skill;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRecruitmentId() {
        return recruitmentId;
    }

    public void setRecruitmentId(int recruitmentId) {
        this.recruitmentId = recruitmentId;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
