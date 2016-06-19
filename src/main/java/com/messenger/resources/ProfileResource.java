package com.messenger.resources;


import com.messenger.model.Message;
import com.messenger.model.Profile;
import com.messenger.service.ProfileService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {

    final ProfileService service = new ProfileService();

    @GET
    public List<Profile> getAllProfiles(){
        return service.getAllProfiles();
    }

    @POST
    public Profile addProfile(Profile profile){
        return service.addProfiler(profile);
    }

    @GET
    @Path("/{profileName}")
    public Profile getProfile(@PathParam("profileName") String profileName){
        return service.getProfiler(profileName);
    }

    @PUT
    @Path("/{profileName}")
    public Profile updateProfile(@PathParam("profileName") String profileName, Profile profile){
        profile.setProfileName(profileName);
        return service.updateProfiler(profile);
    }
}
