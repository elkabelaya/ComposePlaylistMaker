import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.elkabelaya.playlistmaker.common.domain.model.Track
import com.elkabelaya.playlistmaker.common.domain.mocks.mockSequence


public class TrackPreviewProvider() : PreviewParameterProvider<Track> {
    override val values = Track.mockSequence()
}



