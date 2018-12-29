package zhang.cqjtu.os;

/**
 * 创建PCB
 * @author Lewis
 */

public class Pcb {
    /**
     * 进程标识数：id
     */
    private int id;
    /**
     * 进程优先数：priority（优先数越大，优先级越高）
     */
    private int priority;
    /**
     * 进程已占用时间片：cpuTime，每得到一次调度，值加1；
     */
    private int cpuTime;
    /**
     * 进程还需占用时间片：allTime，每得到一次调度，该值减1，一旦运行完毕，allTime为0
     * */
    private int allTime;
    /**
     * 进程状态：STATE（一般为就绪，可以不用），状态为1的时候表示准备就绪
     */
    private int state;

    public Pcb(){}

    /**
     * 初始化PCB的基本信息的构造方法
     * @param id
     * @param priority
     * @param cpuTime
     * @param allTime
     * @param state
     */
    public Pcb(int id, int priority, int cpuTime, int allTime, int state){
        super();
        this.id = id;
        this.priority = priority;
        this.cpuTime = cpuTime;
        this.allTime = allTime;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * 根据要求来修改PCB的优先级
     */
    public void modifyPriority() {
        if (0 < this.priority) {
            this.priority -= 3;
        }
    }

    public int getCpuTime() {
        return cpuTime;
    }

    public void setCpuTime(int cpuTime) {
        this.cpuTime = cpuTime;
    }

    /**
     * 根据要求修改CPU时间
     */
    public void modifyCpuTime() {
        this.cpuTime += 1;
    }


    public int getAllTime() {
        return allTime;
    }

    public void setAllTime(int allTime) {
        this.allTime = allTime;
    }

    /**
     * 根据要求修改PCB占用的时间片
     */
    public void modifyAllTime() {
        if (0 < this.allTime) {
            this.allTime -= 1;
        }
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    /**
     * 根据要求修改PCB的状态
     */
    public void midifyState() {

    }
    /**
     * 打印显示当前PCB的全部信息
     */
    public void showStatus() {
        System.out.println("PCB [id=" + id + ", priority=" + priority
                + ", cpuTime=" + cpuTime + ", allTime=" + allTime + ", state="
                + state + "]");
    }

    /**
     * 修改PCB的全部信息
     */
    public void modify() {
        if (0 < this.allTime) {
            this.allTime -= 1;
        }
        this.cpuTime += 1;
        if (0 < this.priority) {
            this.priority -= 3;
        }
    }





}
