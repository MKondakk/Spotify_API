
package org.mkondak.app.spotify.contract;


public class SearchResultDto {

    private ResponseDto<ArtistItemDto> artists;

    public ResponseDto<ArtistItemDto> getArtists() {
        return artists;
    }

    public void setArtists(ResponseDto<ArtistItemDto> artists) {
        this.artists = artists;
    }

}
