import java.util.*;
public class Minimum_time_required_to_rot_all_oranges_without_graph {
    static class Classes{
        int item;
        public Classes(int i){
            this.item = i;
        }
    }
    static void createGraph(ArrayList<Classes>[] graph, int[][] arr){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
            for(int j = 0; j < arr[0].length; j++){
                graph[i].add(new Classes(arr[i][j]));
            }
        }
    }

    public static int minTime(ArrayList<Classes>[] graph){
        for(int i = 0; i < graph.length; i++){
            if(i == 0){
                for(int j = 0; j < graph[i].size(); j++){
                    if(j == 0){
                        Classes c = graph[i].get(j);
                        if(c.item == 1){
                            if(graph[i].get(j+1).item == 2){
                                c.item = 2;
                            }else if(graph[i+1].get(j).item == 2){
                                c.item = 2;
                            }
                        }
                    }
                    else if(j == graph[i].size() - 1){
                        Classes c = graph[i].get(j);
                        if(c.item == 1){
                            if(graph[i].get(j-1).item == 2){
                                c.item = 2;
                            }else if(graph[i+1].get(j).item == 2){
                                c.item = 2;
                            }
                        }
                    }
                    else{
                        Classes c = graph[i].get(j);
                        if(c.item == 1){
                            if(graph[i].get(j+1).item == 2){
                                c.item = 2;
                            }else if(graph[i].get(j-1).item == 2){
                                c.item = 2;
                            }
                            else if(graph[i+1].get(j).item == 2){
                                c.item = 2;
                            }
                        }
                    }
                }
            }
            else if(i == graph.length - 1){
                for(int j = 0; j < graph[i].size(); j++){
                    if(j == 0){
                        Classes c = graph[i].get(j);
                        if(c.item == 1){
                            if(graph[i].get(j+1).item == 2){
                                c.item = 2;
                            }else if(graph[i-1].get(j).item == 2){
                                c.item = 2;
                            }
                        }
                    }
                    else if(j == graph[i].size() - 1){
                        Classes c = graph[i].get(j);
                        if(c.item == 1){
                            if(graph[i].get(j-1).item == 2){
                                c.item = 2;
                            }else if(graph[i-1].get(j).item == 2){
                                c.item = 2;
                            }
                        }
                    }
                    else{
                        Classes c = graph[i].get(j);
                        if(c.item == 1){
                            if(graph[i].get(j+1).item == 2){
                                c.item = 2;
                            }else if(graph[i].get(j-1).item == 2){
                                c.item = 2;
                            }
                            else if(graph[i-1].get(j).item == 2){
                                c.item = 2;
                            }
                        }
                    }
                }

            }
            else{
                for(int j = 0; j < graph[i].size(); j++){
                    Classes c = graph[i].get(j);
                    if(c.item == 1){
                        if(graph[i+1].get(j).item == 2){
                            c.item = 2;
                        }
                        else if(graph[i-1].get(j).item == 2){
                            c.item = 2;
                        }
                        else if(graph[i].get(j+1).item == 2){
                            c.item = 2;
                        }else if(graph[i].get(j-1).item == 2){
                            c.item = 2;
                        }
                    }
                }
            }
            if(checkComplete(graph)){
                return i;
            }
        }
        return -1;
    }

    public static boolean checkComplete(ArrayList<Classes>[] graph){
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[i].size(); j++){
                Classes c = graph[i].get(j);
                if(c.item == 1){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int m = 3, n = 5;
        int[][] arr = {{2, 1, 0, 2, 1},
                {1, 1, 0, 2, 1},
                {1, 0, 0, 2, 1}};
        ArrayList<Classes>[] graph = new ArrayList[m];
        createGraph(graph, arr);
        System.out.println(minTime(graph));
    }
}
