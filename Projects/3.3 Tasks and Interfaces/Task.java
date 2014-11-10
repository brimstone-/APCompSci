public class Task implements Priority, Complexity, Comparable<Task>
{
    public int priority,complexityLevel;
    public String name;
    public Task(String s)
    {
        name = s;
        priority = 0;
        complexityLevel = 0;
    }
    
    public Task(int n, int c)
    {
        priority = n;
        complexityLevel = c;
    }

    public void setPriority(int n)
    {
        priority = n;
    }

    public int getPriority()
    {
        return priority;
    }

    public void setComplexity (int level)
    {
        complexityLevel = level;
    }

    public int getComplexity()
    {
        return complexityLevel;
    }
    
    public int compareTo(Task t)
    {
        return this.priority-t.priority;
    }
    
    public String toString()
    {
        return "The priority of the task is " + priority + " and the complexity of the task is " + complexityLevel + ".";
    }
}
