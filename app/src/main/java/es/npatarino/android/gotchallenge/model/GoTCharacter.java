package es.npatarino.android.gotchallenge.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Nicolás Patarino on 21/02/16.
 */
public class GoTCharacter {

    @SerializedName("name")
    String characterName;
    @SerializedName("imageUrl")
    String characterPosterPath;
    @SerializedName("description")
    String description;
    @SerializedName("houseImageUrl")
    String housePosterPath;
    @SerializedName("houseName")
    String houseName;
    @SerializedName("houseId")
    String houseID;

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getCharacterPosterPath() {
        return characterPosterPath;
    }

    public void setCharacterPosterPath(String characterPosterPath) {
        this.characterPosterPath = characterPosterPath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHousePosterPath() {
        return housePosterPath;
    }

    public void setHousePosterPath(String housePosterPath) {
        this.housePosterPath = housePosterPath;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getHouseID() {
        return houseID;
    }

    public void setHouseID(String houseID) {
        this.houseID = houseID;
    }

    /**
     * Created by Nicolás Patarino on 21/02/16.
     */


    public static class GoTHouse {

        @SerializedName("houseImageUrl")
        String houseImagePosterPath;
        @SerializedName("houseName")
        String houseName;
        @SerializedName("houseId")
        String houseID;

        public String getHouseImagePosterPath() {
            return houseImagePosterPath;
        }

        public void setHouseImagePosterPath(String houseImagePosterPath) {
            this.houseImagePosterPath = houseImagePosterPath;
        }

        public String getHouseName() {
            return houseName;
        }

        public void setHouseName(String houseName) {
            this.houseName = houseName;
        }

        public String getHouseID() {
            return houseID;
        }

        public void setHouseID(String houseID) {
            this.houseID = houseID;
        }
    }
}
