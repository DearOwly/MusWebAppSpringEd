package so.sonya.muswebapp2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import so.sonya.muswebapp2.dto.request.LikeRequest;
import so.sonya.muswebapp2.exception.forbidden.ForbiddenResourceModificationException;
import so.sonya.muswebapp2.exception.notfound.MessageNotFoundException;
import so.sonya.muswebapp2.exception.notfound.UserNotFoundException;
import so.sonya.muswebapp2.model.Like;
import so.sonya.muswebapp2.model.Message;
import so.sonya.muswebapp2.model.user.User;
import so.sonya.muswebapp2.repository.LikeRepository;
import so.sonya.muswebapp2.repository.MessageRepository;
import so.sonya.muswebapp2.repository.UserRepository;
import so.sonya.muswebapp2.service.MessageService;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageRepository repository;
    private final LikeRepository likeRepository;
    private final UserRepository userRepository;

    @Override
    public void like(LikeRequest request, UUID userId) {
        Message message = repository.findById(request.resourceId())
                                    .orElseThrow(MessageNotFoundException::new);

        Optional<Like> likeOptional = likeRepository.findById(request.id());

        if (likeOptional.isPresent() && !request.like()) {
            Like like = likeOptional.get();

            if (!like.getUser()
                     .getId()
                     .equals(userId)) {
                throw new ForbiddenResourceModificationException(Message.class);
            }

            message.removeLike(like);
        } else if (likeOptional.isEmpty() && request.like()) {
            User user = userRepository.findById(userId)
                                      .orElseThrow(UserNotFoundException::new);

            Like like = new Like(user);

            message.addLike(like);
        }

        repository.save(message);
    }
}
