package ua.pp.blastorq.pentomino;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import ua.pp.blastorq.pentomino.screens.GameScreen;

public class Area extends  Rectangle {
    public int[][] matrix;
    public final int mW = 12, mH = 5;
    public int currentColor, currentL, currentT;

    public int[][] matrixBackup;
    public int currentColorBackup, currentLBackup, currentTBackup;

    int[][][] M;
    public Area() {
        int[][][] M = {
                {
                        {0, 1, 0},
                        {1, 1, 1},
                        {0, 1, 0}
         }, {
                {1, 1, 1, 1, 1}
        }, {
                {1, 1, 1},
                {0, 1, 0},
                {0, 1, 0}
        }, {
                {1, 0, 1},
                {1, 1, 1},
        }, {
                {1, 0, 0},
                {1, 0, 0},
                {1, 1, 1}
        }, {
                {1, 0, 0},
                {1, 1, 0},
                {0, 1, 1}
        }, {
                {1, 1, 0},
                {1, 1, 1}
        }, {
                {1, 1, 0},
                {0, 1, 0},
                {0, 1, 1}
        }, {
                {1, 0, 0, 0},
                {1, 1, 1, 1}
        }, {
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        }, {
                {0, 1, 1, 1},
                {1, 1, 0, 0}
        }, {
                {1, 0, 0},
                {1, 1, 1},
                {0, 1, 0}
        }
        };
        this.M = M;

        int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        this.matrix = matrix;
		this.matrixBackup = matrix;
    }
    public void render(){
        int offsetX = 30;
        int offsetY = 80;
        int textureW = 50;
        int textureH = 50;
        int borderWidth = 1;
        for(int i = 0; i< mH; i++){
            for(int j = 0; j< mW; j++){
                GameScreen.batch.begin();
                GameScreen.batch.draw(getTextureByColor(-1), offsetX+textureW*j, offsetY+textureH*(mH -i), textureW, textureH);
                GameScreen.batch.draw(getTextureByColor(matrix[i][j]), offsetX+textureW*j+borderWidth, offsetY+textureH*(mH -i)+borderWidth, textureW-borderWidth*2, textureH-borderWidth*2);
                GameScreen.batch.end();
            }
        }
    }
    public boolean tryAdd(int n){
        for(int i = 0; i< matrix.length; i++){
            for(int j = 0; j< matrix[i].length; j++){
                if(tryAddFigure(n, i, j)){
					currentColor = n;
					currentT = i;
					currentL = j;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean tryAddFigure(int n, int top, int left){
        int[][] fig = M[n];
        //Check
        for(int i=top; i<top+fig.length; i++){
            for(int j=left; j<left+fig[i-top].length; j++){
                if(i < matrix.length && j < matrix[i].length) {
                    if (matrix[i][j] > 100 && fig[i - top][j - left] > 0) {
                        return false;
                    }
                }

                if(i >= matrix.length || j >= matrix[i].length) {
                    //if (fig[i - top][j - left] > 0) {
                        return false;
                    //}
                }
            }
        }

        //Do
        for(int i=top; i<top+fig.length; i++){
            for(int j=left; j<left+fig[i-top].length; j++){
                if(i < matrix.length && j < matrix[i].length) {
                    if (fig[i - top][j - left] > 0) {
						matrix[i][j] = fig[i - top][j - left] * (n + 101);
                    }
                }
            }
        }
        return true;
    }


	public boolean tryRemove(){
		return tryRemoveFigure(currentColor);
	}
	public boolean tryRemove(int n){
		return tryRemoveFigure(n);
	}
    public boolean tryRemoveFigure(int n){
        for(int i=0; i<mH; i++){
            for(int j=0; j<mW; j++){
				if(matrix[i][j] == n + 101){
					matrix[i][j] = 0;
				}
            }
        }
        return true;
    }
    public boolean tryRotate(Direction direction) {
		this.makeBackup();
        if(
				this.tryRemove() &&
					this.tryRotateFigure(direction) &&
					this.tryAdd(this.currentColor)//, this.currentT, this.currentL)
        ){
            return true;
        }else{
			restoreBackup();
        }
        return false;
    }
        public boolean tryRotateFigure(Direction direction){
        int n = this.currentColor;

        int[][] t = this.M[n];
        int[][] q = new int[t[0].length][t.length];
        for(int i = 0; i < q.length; i++){
            for(int j = 0; j < q[0].length; j++){
                switch(direction){
                    case LEFT_ROTATE:
                        q[i][j] = t[j][q.length-i-1];
                        break;
                    case RIGHT_ROTATE:
                        q[i][j] = t[q[i].length-j-1][i];
                        break;
                }
            }
        }
			this.M[n] = q;
        return true;
    }
    private Texture getTextureByColor(int color){
        Texture ret;
        color = color % 100;
        switch (color){
            case -1:
                ret = GameScreen.color_border;
                break;
            case 0:
                ret = GameScreen.color_empty;
                break;
            case 1:
                return GameScreen.color_black;
            case 2:
                ret = GameScreen.color_dblue;
                break;
            case 3:
                ret = GameScreen.color_dgreen;
                break;
            case 4:
                ret = GameScreen.color_red;
                break;
            case 5:
                ret = GameScreen.color_dviolet;
                break;
            case 6:
                ret = GameScreen.color_yellow;
                break;
            case 7:
                ret = GameScreen.color_lblue;
                break;
            case 8:
                ret = GameScreen.color_lviolet;
                break;
            case 9:
                ret = GameScreen.color_orange;
				break;
            case 10:
                ret = GameScreen.color_dred;
                break;
            case 11:
                ret = GameScreen.color_sgreen;
                break;
            case 12:
                ret = GameScreen.color_lgreen;
                break;
            default: ret = null;
        }
        return ret;
    }
    void makeBackup(){
		this.matrixBackup = this.matrix;
		this.currentColorBackup = this.currentColor;
		this.currentLBackup = this.currentL;
		this.currentTBackup = this.currentT;
    }
    void restoreBackup(){
		this.matrix = this.matrixBackup;
		this.currentColor = this.currentColorBackup;
		this.currentL = this.currentLBackup;
		this.currentT = this.currentTBackup;
    }
}