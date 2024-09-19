import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> musicCnt = new HashMap<>();
        Map<String, List<Song>> genreSong = new HashMap<>();
        
        for(int i=0; i<genres.length; i++){
            musicCnt.put(genres[i], musicCnt.getOrDefault(genres[i], 0)+plays[i]);
            
            Song song = new Song(i, plays[i]);
            if(!genreSong.containsKey(genres[i])){
                genreSong.put(genres[i], new ArrayList<>());
            }
            genreSong.get(genres[i]).add(song);
        }
        
        List<String> sortedGenres = new ArrayList<>(musicCnt.keySet());
        sortedGenres.sort((a,b) -> musicCnt.get(b) - musicCnt.get(a));
        
        ArrayList<Integer> answer = new ArrayList<>();
        for(String genre: sortedGenres){
            genreSong.get(genre).sort((a,b) -> {
                                      if(a.playCnt == b.playCnt){return a.i - b.i;}
                                      else {return b.playCnt - a.playCnt;}});
            List<Song> songList = genreSong.get(genre);
            int songIdx = 0;
            for(int idx=0; idx<2; idx++){
                if(songList.size() > idx){
                    songIdx = genreSong.get(genre).get(idx).i;
                    answer.add(songIdx);
                }
            }
            
        }
        int[] realAnswer = new int[answer.size()];
        for(int i=0; i<answer.size(); i++){
            realAnswer[i] = answer.get(i);
        }
        return realAnswer;
    }
    
    class Song{
        int i;
        int playCnt;
        
        Song(int i, int playCnt){
            this.i = i;
            this.playCnt = playCnt;
        }
    }
}