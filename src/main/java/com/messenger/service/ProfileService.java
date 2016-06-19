package com.messenger.service;

import com.messenger.database.DatabaseClass;
import com.messenger.model.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProfileService {

    private Map<String, Profile> profiles = DatabaseClass.getProfiles();

    public ProfileService() {
        profiles.put("linnik", new Profile(1L, "Profile1", "Linnik", "Oleg"));
    }

    public List<Profile> getAllProfiles(){
        return new ArrayList<>(profiles.values());
    }

    public Profile getProfiler(String profileName){
        return profiles.get(profileName);
    }

    public Profile addProfiler(Profile profile){
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }

    public Profile updateProfiler(Profile profile){
        if(profile.getProfileName().isEmpty()){
            return null;
        }
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }

    public Profile removeProfiler(String profileName){
        return profiles.remove(profileName);
    }
}
