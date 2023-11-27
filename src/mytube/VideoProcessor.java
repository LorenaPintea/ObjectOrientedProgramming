package mytube;

public class VideoProcessor {
    private Encoding encoder;
    private DatabaseStoring database;
    private SendingNotification emailService;
    public VideoProcessor(Encoding encoder, DatabaseStoring database, SendingNotification emailService) {
        this.encoder = encoder;
        this.database = database;
        this.emailService = emailService;
    }

    public void process(Video video) {
        encoder.encode(video);
        database.store(video);
        emailService.sendEmail(video.getUser());
    }
}

