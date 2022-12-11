package ddwu.mobile.finalreport.finalreport_02_20201030;

import java.io.Serializable;

public class Music implements Serializable {
    long _id;
    String title;
    String artist;
    String genre;
    String date;
    String report;
    String lyrics;

    public Music(String title, String artist, String genre) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
    }

    public Music(long _id, String title, String artist, String genre, String date, String report, String lyrics) {
        this._id = _id;
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.date = date;
        this.report = report;
        this.lyrics = lyrics;
    }

    @Override
    public String toString() {
        return "Music{" +
                "_id=" + _id +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", genre='" + genre + '\'' +
                ", date='" + date + '\'' +
                ", report='" + report + '\'' +
                ", lyrics='" + lyrics + '\'' +
                '}';
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }
}
