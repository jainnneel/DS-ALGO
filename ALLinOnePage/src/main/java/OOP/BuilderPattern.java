package OOP;

 class BuilderPattern {

    String name;
    
    int age;
    
    String gender;

    BuilderPattern name(String name) {
        this.name = name;
        return this;
    }
    BuilderPattern age(int age) {
        this.age = age;
        return this;
    }
    BuilderPattern gender(String gender) {
        this.gender = gender;
        return this;
    }
    
    BuilderPattern build() {
        return this;
    }
    @Override
    public String toString() {
        return "BuilderPattern [name=" + name + ", age=" + age + ", gender=" + gender + "]";
    }
    
    
    
    
}

class main{
    
    public main() {
        
        BuilderPattern build = new BuilderPattern().name("sdad").age(45).gender("dsa").build();
        System.out.println(build);
    
    }
}









