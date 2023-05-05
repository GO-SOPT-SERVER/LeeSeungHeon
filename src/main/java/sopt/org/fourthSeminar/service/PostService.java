package sopt.org.fourthSeminar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.org.fourthSeminar.controller.dto.response.PostResponseDto;
import sopt.org.fourthSeminar.domain.Post;
import sopt.org.fourthSeminar.exception.Error;
import sopt.org.fourthSeminar.exception.model.NotFoundException;
import sopt.org.fourthSeminar.infrastructure.PostRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public List<PostResponseDto> getList() {
        List<Post> postList = postRepository.findAll();

        return postList.stream()
                .map(post -> PostResponseDto.of(
                        post.getId(),
                        post.getImgSrc(),
                        post.getName(),
                        post.getDate(),
                        post.getContent()))
                .collect(Collectors.toList());
    }

    @Transactional
    public PostResponseDto getOne(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Error.NOT_FOUND_POST_EXCEPTION, Error.NOT_FOUND_POST_EXCEPTION.getMessage()));

        return PostResponseDto.of(post.getId(), post.getImgSrc(), post.getName(), post.getDate(), post.getDate());
    }
}
