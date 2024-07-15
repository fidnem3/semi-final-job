let selectedFilters = {
    function: [],
    experience: [],
    job: [],
    location: []
};


function toggleFilterOptions(filterType) {
    const filterElement = document.getElementById(filterType + 'Filter');
    if (filterElement) {
        // 다른 모든 필터 옵션을 닫습니다.
        document.querySelectorAll('.filter-options').forEach(el => {
            if (el !== filterElement) {
                el.style.display = 'none';
            }
        });
        // 클릭된 필터 옵션을 토글합니다.
        filterElement.style.display = filterElement.style.display === 'none' ? 'block' : 'none';
        
        // 모든 버튼에서 'active' 클래스를 제거합니다.
        document.querySelectorAll('.filter-buttons button').forEach(btn => {
            btn.classList.remove('active');
        });
        // 클릭된 버튼에 'active' 클래스를 토글합니다.
        event.target.classList.toggle('active');
    }
}

function toggleFilter(filterType, value, button) {
    const index = selectedFilters[filterType].indexOf(value);
    
    if (index > -1) {
        selectedFilters[filterType].splice(index, 1);
        button.classList.remove('selected');
    } else {
        selectedFilters[filterType].push(value);
        button.classList.add('selected');
    }
    
    applyFilters();
}

function applyFilters() {
    const filteredPostings = jobPostings.filter(posting => {
        return (selectedFilters.function.length === 0 || selectedFilters.function.includes(posting.function)) &&
               (selectedFilters.experience.length === 0 || selectedFilters.experience.includes(posting.experience)) &&
               (selectedFilters.job.length === 0 || selectedFilters.job.includes(posting.job)) &&
               (selectedFilters.location.length === 0 || selectedFilters.location.includes(posting.location));
    });

    displayJobPostings(filteredPostings);
}

function displayJobPostings(postings) {
    const container = document.getElementById('jobPostings');
    container.innerHTML = '';

    if (postings.length === 0) {
        container.innerHTML = '<p>해당하는 채용 공고가 없습니다.</p>';
        return;
    }

    postings.forEach(posting => {
        const postingElement = document.createElement('div');
        postingElement.className = 'job-post-box';
        postingElement.innerHTML = `
            <h3>${posting.title}</h3>
            <p>회사: ${posting.compId}</p>
            <p>직무: ${posting.function}</p>
            <p>경력: ${posting.experience}</p>
            <p>직종: ${posting.job}</p>
            <p>위치: ${posting.location}</p>
            <p>마감일: ${posting.endDate}</p>
        `;
        postingElement.onclick = () => openJobDetails(posting.jobPostId);
        container.appendChild(postingElement);
    });
}

function openJobDetails(jobPostId) {
    const url = `/jobPost/detail/${jobPostId}`;
    window.open(url, '_blank', 'width=800,height=600');
}



document.addEventListener('DOMContentLoaded', function() {
    // 초기 채용 공고 표시
    displayJobPostings(jobPostings);

    // 필터 버튼 이벤트 리스너 설정
    const filterButtons = document.querySelectorAll('.filter-buttons button');
    filterButtons.forEach(button => {
        button.addEventListener('click', function(event) {
            const filterType = this.textContent.replace('별', '');
            toggleFilterOptions(filterType);
        });
    });

    // 필터 옵션 버튼 이벤트 리스너 설정
    const filterOptionButtons = document.querySelectorAll('.filter-options button');
    filterOptionButtons.forEach(button => {
        button.addEventListener('click', function(event) {
            const filterType = this.closest('.filter-options').id.replace('Filter', '');
            const value = this.textContent;
            toggleFilter(filterType, value, this);
        });
    });
});