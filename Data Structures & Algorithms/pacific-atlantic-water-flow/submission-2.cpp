class Solution {
public:
    void solve(vector<vector<int>>& vec,vector<vector<int>> &vis,int cnt){
        int n=vec.size();
        int m=vec[0].size();

        queue<pair<int,int>> q;

        if(cnt==0){
            for(int i=0;i<m;i++){
                q.push({0,i});
                vis[0][i]=1;
            }
            for(int i=1;i<n;i++){
                q.push({i,0});
                vis[i][0]=1;
            }

            vector<pair<int,int>> dir={{-1,0},{0,1},{0,-1},{1,0}};

            while(!q.empty()){
                auto [row,col]=q.front();
                q.pop();



                for(auto &it:dir){
                    int newrow=row+it.first;
                    int newcol=col+it.second;

                    if(newrow<0 || newrow>=n || newcol<0 || newcol>=m || 
                    vis[newrow][newcol]!=-1 || 
                    vec[newrow][newcol]<vec[row][col]) continue;

                    vis[newrow][newcol]=1;

                    q.push({newrow,newcol});
                }
            }
        }


        else if(cnt==1) {
            for(int i=0;i<n;i++){
                q.push({i,m-1});
                vis[i][m-1]=1;
            }
            for(int i=0;i<m-1;i++){
                q.push({n-1,i});
                vis[n-1][i]=1;
            }

            vector<pair<int,int>> dir={{-1,0},{0,1},{0,-1},{1,0}};

            while(!q.empty()){
                auto [row,col]=q.front();
                q.pop();



                for(auto &it:dir){
                    int newrow=row+it.first;
                    int newcol=col+it.second;

                    if(newrow<0 || newrow>=n || newcol<0 || newcol>=m || 
                    vis[newrow][newcol]!=-1 || 
                    vec[newrow][newcol]<vec[row][col]) continue;

                    vis[newrow][newcol]=1;

                    q.push({newrow,newcol});
                }
            }
        }
        return ;
    }
    vector<vector<int>> pacificAtlantic(vector<vector<int>>& heights) {
        int n=heights.size();
        int m=heights[0].size();

        vector<vector<int>> visp(n,vector<int> (m,-1));
        vector<vector<int>> visa(n,vector<int> (m,-1));
        solve(heights,visp,0);
        solve(heights,visa,1);


        vector<vector<int>> ans;
        for(int i=0;i<n;i++){
            vector<int> temp;
            for(int j=0;j<m;j++){
                if(visp[i][j]==visa[i][j] && visp[i][j]==1){
                    temp.push_back(i);
                    temp.push_back(j);
                    ans.push_back(temp);
                    temp.clear();
                }
            }
            // ans.push_back(temp);
        }
        return ans;
    }
};
